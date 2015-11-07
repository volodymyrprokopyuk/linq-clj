(ns linq-clj.query)

(defn xdeferred [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         lazy-index (range 0 (count nums)) ]
    (map vector nums lazy-index)))

(defn immediate [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         index (doall (range 0 (count nums))) ]
    (map vector nums index)))

(defn reuse [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         neg-nums (map - nums) ]
    [ (filter #(<= %1 3) nums) (filter #(<= %1 3) neg-nums) ]))
