(ns linq-clj.aggregate)

(defn count-simple [ ]
  (let [ nums [ 2, 2, 3, 5, 5 ] ]
    (->> nums distinct count)))

(defn count-cond [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (->> nums (filter odd?) count)))

(defn count-nested [ customers ]
  (for [ customer customers ]
    [ (:id customer) (-> customer :orders count) ]))

(defn count-grouped [ products ]
  (for [ [ c ps ] (group-by :category products) ]
    [ c (count ps) ]))

(defn sum-simple [ ]
  (let [ nums [ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 ] ]
    (apply + nums)))

(defn sum-projection [ ]
  (let [ words [ "cherry", "apple", "blueberry" ] ]
    (->> words (map count) (apply +))))

(defn sum-grouped [ products ]
  (for [ [ c ps ] (group-by :category products) ]
    [ c (->> ps (map :in-stock) (apply +)) ]))

(defn min-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (apply min nums)))

(defn min-projection [ ]
  (let [ words [ "cherry", "apple", "blueberry" ] ]
    (->> (map count words) (apply min))))

(defn min-grouped [ products ]
  (for [ [ c ps ] (group-by :category products) ]
    [ c (->> ps (map :price) (apply min)) ]))

(defn min-elements [ products ]
  (for [ [ c ps ] (group-by :category products) ]
    [ c (apply min-key :price ps) ]))

(defn max-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (apply max nums)))

(defn max-projection [ ]
  (let [ words [ "cherry", "apple", "blueberry" ] ]
    (->> words (map count) (apply max))))

(defn max-grouped [ products ]
  (for [ [ c ps ] (group-by :category products) ]
    [ c (->> ps (map :price) (apply max)) ]))

(defn max-elements [ products ]
  (for [ [ c ps ] (group-by :category products) ]
    [ c (apply max-key :price ps) ]))

(defn average-simple [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (/ (apply + nums) (count nums))))

(defn average-projection [ ]
  (let [ words [ "cherry", "apple", "blueberry" ] ]
    (/ (->> words (map count) (apply +)) (count words))))

(defn average-grouped [ products ]
  (for [ [ c ps ] (group-by :category products)
         :let [ avg (/ (->> ps (map :price) (apply +)) (count ps)) ] ]
    [ c avg ]))

(defn aggregate-simple [ ]
  (let [ nums [ 1.7 2.3 1.9 4.1 2.9 ] ]
    (apply * nums)))

(defn aggregate-seed [ ]
  (let [ nums [ 20 10 40 50 10 70 30 ] ]
    (reduce
      (fn [ balance withdrawal ]
        (if (<= withdrawal balance)
          (- balance withdrawal)
          balance))
      100 nums)))
