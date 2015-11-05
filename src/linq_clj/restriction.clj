(ns linq-clj.restriction)

(defn where1 [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (for [ num nums :when (< num 5) ]
      num)))

(defn where2 [ products ]
  (for [ product products :when (= (:in-stock product) 0) ]
    product))

(defn where3 [ products ]
  (for [ product products
         :when (and (> (:in-stock product) 0) (> (:price product) 3.0)) ]
    product))

(defn drilldown [ customers ]
  (for [ customer customers :when (= (:city customer) "Madrid") ]
    customer))

(defn indexed [ ]
  (let [ digits [ "zero" "one" "two" "three" "four" "five" "six" "seven"
                  "eight" "nine" ] ]
    (for [ [ index digit ] (map-indexed vector digits)
           :when (< (count digit) index) ]
      digit)))
