(ns linq-clj.partitioning)

(defn take-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (take 3 nums)))

(defn take-nested [ customers ]
  (take 3
    (for [ customer customers
           :when (= (:city customer) "Madrid")
           order (:orders customer) ]
      [ (:id customer) (:id order) ])))

(defn skip-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (drop 4 nums)))

(defn skip-nested [ customers ]
  (drop 2
    (for [ customer customers
           :when (= (:city customer) "Madrid")
           order (:orders customer) ]
      [ (:id customer) (:id order) ])))

(defn take-while-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (for [ num nums :while (< num 6) ]
      num)))

(defn take-while-indexed [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (for [ [ index num ] (map-indexed vector nums)
           :while (>= num index) ]
      num)))

(defn skip-while-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (drop-while #(not= (mod %1 3) 0) nums)))

(defn skip-while-indexed [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (map second
      (drop-while (fn [ [ index num ] ] (>= num index))
        (map-indexed vector nums)))))
