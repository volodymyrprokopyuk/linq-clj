(ns linq-clj.misc)

(defn concat1 [ ]
  (let [ xs [ 0 2 4 5 6 8 9 ]
         ys [ 1 3 5 7 8 ] ]
    (concat xs ys)))

(defn concat2 [ customers products ]
  (let [ cnames (map :name customers)
         pnames (map :name products) ]
    (concat cnames pnames)))

(defn equal1 [ ]
  (let [ xs [ "cherry" "apple" "blueberry" ]
         ys [ "cherry" "apple" "blueberry" ] ]
    (= xs ys)))

(defn equal2 [ ]
  (let [ xs [ "cherry" "apple" "blueberry" ]
         ys [ "apple" "blueberry" "cherry" ] ]
    (= xs ys)))
