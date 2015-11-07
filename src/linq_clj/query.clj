(ns linq-clj.query)

(defn xdeferred [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         lazy-index (range 0 (count nums)) ]
    (map vector nums lazy-index)))

(defn immediate [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ]
         index (doall (range 0 (count nums))) ]
    (map vector nums index)))

(defn reuse1 [ ]
  (let [ le3 (partial filter #(<= %1 3))
         nums1 [ 5 4 1 3 9 8 6 7 2 0 ]
         nums2 (map - nums1)
         res1 (le3 nums1)
         res2 (le3 nums2) ]
    [ res1 res2 ]))

(def ^:dynamic *nums* [ 5 4 1 3 9 8 6 7 2 0 ])

(defn reuse2 [ ]
  (let [ le3 (partial filter #(<= %1 3))
         res1 (le3 *nums*)
         res2 (binding [ *nums* (map - *nums*) ]
                (le3 *nums*)) ]
    [ res1 res2 ]))
