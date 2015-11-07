(ns linq-clj.element)

(defn first-simple [ products ]
  (->> products (filter #(= (:id %1) 12)) first))

(defn first-cond [ ]
  (let [ digits [ "zero" "one" "two" "three" "four" "five" "six"
                  "seven" "eight" "nine" ] ]
    (->> digits (filter #(re-find #"^o" %1)) first)))

(defn first-or-default-simple [ ]
  (let [ nums [ ] ]
    (get nums 0 0)))

(defn first-or-default-cond [ products ]
  (->> products (filter #(= (:id %1) 789)) first))

(defn element-at [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (->> nums (filter #(> %1 5)) second)))
