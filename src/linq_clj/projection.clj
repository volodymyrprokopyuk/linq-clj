(ns linq-clj.projection
  (:require
    [ clojure.string :as str ]
    [ clojure.set :as set ]
    [ clj-time.core :as tm ]
    [ clj-time.format :as tmf ]))

(defn select1 [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (for [ num nums ]
      (+ num 1))))

(defn select2 [ products ]
  (for [ product products ]
    (:name product)))

(defn transform [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         digits [ "zero" "one" "two" "three" "four" "five" "six" "seven"
                  "eight" "nine" ] ]
    (for [ num nums ]
      (get digits num))))

(defn anonymous1 [ ]
  (let [ words [ "aPPLE" "BlUeBeRrY" "cHeRry" ] ]
    (for [ word words ]
      ((juxt str/upper-case str/lower-case) word))))

(defn anonymous2 [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         digits [ "zero" "one" "two" "three" "four" "five" "six" "seven"
                  "eight" "nine" ] ]
    (for [ num nums ]
      (let [ digit (get digits num)
             type (if (even? num) "even" "odd") ]
        [ digit type ]))))

(defn anonymous3 [ products ]
  (-> products
    (set/project [ :name :category :price ])
    (set/rename { :price :unit-price })))

(defn indexed [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (for [ [ index num ] (map-indexed vector nums) ]
      [ num (= num index) ])))

(defn filtered [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         digits [ "zero" "one" "two" "three" "four" "five" "six" "seven"
                  "eight" "nine" ] ]
    (for [ num nums :when (< num 5) ]
      (get digits num))))

(defn compound1 [ ]
  (let [ xs [ 0 2 4 5 6 8 9 ]
         ys [ 1 3 5 7 8 ] ]
    (for [ x xs y ys :when (< x y) ]
      [ x y ])))

(defn compound2 [ customers ]
  (for [ customer customers
         order (:orders customer)
         :when (< (:total order) 500.0) ]
      [ (:id customer) (:id order) (:total order) ]))

(defn compound3 [ customers ]
  (let [ tf (tmf/formatters :date-hour-minute-second) ]
    (for [ customer customers
           order (:orders customer)
           :when (tm/after? (:date order)
                   (tmf/parse tf "1998-01-01T00:00:00")) ]
      [ (:id customer) (:id order) (:total order)
        (tmf/unparse tf (:date order)) ])))

(defn assignment [ customers ]
  (for [ customer customers
         order (:orders customer)
         :when (>= (:total order) 2000.0) ]
    [ (:id customer) (:id order) (:total order) ]))

(defn multiple [ customers ]
  (let [ tf (tmf/formatters :date-hour-minute-second) ]
    (for [ customer customers
           :when (= (:city customer) "Madrid")
           order (:orders customer)
           :when (tm/after? (:date order)
                   (tmf/parse tf "1998-01-01T00:00:00")) ]
      [ (:id customer) (:id order) (:city customer)
        (tmf/unparse tf (:date order)) ])))

(defn indexed [ customers ]
  (for [ [ index customer ] (map-indexed vector customers)
         order (:orders customer) ]
    [ index (:id order) ]))
