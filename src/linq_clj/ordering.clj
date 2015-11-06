(ns linq-clj.ordering
  (:require [ clojure.string :as str ]))

(defn order-by1 [ ]
  (let [ words [ "cherry" "apple" "blueberry" ] ]
    (sort words)))

(defn order-by2 [ ]
  (let [ words [ "cherry" "apple" "blueberry" ] ]
    (sort-by count words)))

(defn order-by3 [ products ]
  (sort-by :name products))

(defn order-by-comparer [ ]
  (let [ words [ "aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry" ] ]
    (sort-by str/lower-case words)))

(defn order-by-desc1 [ ]
  (let [ nums [ 1.7 2.3 1.9 4.1 2.9 ] ]
    (sort #(compare %2 %1) nums)))

(defn order-by-desc2 [ products ]
  (sort-by :in-stock (comp - compare) products))

(defn order-by-desc-comparer [ ]
  (let [ words [ "aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry" ] ]
    (sort-by str/lower-case #(compare %2 %1) words)))

(defn then-by [ ]
  (let [ digits [ "zero" "one" "two" "three" "four" "five" "six" "seven"
                  "eight" "nine" ] ]
    (sort-by (juxt count identity) digits)))

(defn then-by-comparer [ ]
  (let [ words [ "aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry" ] ]
    (sort-by (juxt count str/lower-case) words)))

(defn then-by-desc [ products ]
  (sort-by (juxt :category (comp - :price)) products))

(defn then-by-desc-comparer [ ]
  (let [ words [ "aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry" ] ]
    (sort
      (fn [ x y ]
        (let [ by-count (compare (count x) (count y))
               by-lower-desc (compare (str/lower-case y) (str/lower-case x)) ]
          (or (some #(and (not (zero? %1)) %1) [ by-count by-lower-desc ])
            by-lower-desc)))
      words)))

(defn xreverse [ ]
  (let [ digits [ "zero" "one" "two" "three" "four" "five" "six" "seven"
                  "eight" "nine" ] ]
    (reverse
      (for [ digit digits :when (re-find #"^.i" digit) ]
        digit))))
