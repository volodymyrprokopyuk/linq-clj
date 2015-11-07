(ns linq-clj.generation)

(defn xrange [ ]
  (for [ x (range 100 150) ]
    [ x (if (even? x) "even" "odd") ]))

(defn xrepeat [ ]
  (repeat 10 7))
