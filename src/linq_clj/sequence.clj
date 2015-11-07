(ns linq-clj.sequence)

(defn combine [ ]
  (let [ xs [ 0 2 4 5 6 ]
         ys [ 1 3 5 7 8 ] ]
    (apply + (map * xs ys))))
