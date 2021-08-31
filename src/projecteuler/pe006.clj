(ns projecteuler.pe006)

(defn sum-of-squares
  "Sum of squares of 1 to (including) n.
   1^2 + 2^2 + ... + n^2"
  [n]
  (->> (range (inc n))
       (map #(* % %))
       (reduce +)))

(defn square-of-sum
  "Square of sum of 1 to (including) n.
   (1 + 2 + ... + n)^2"
  [n]
  (let [sum (reduce + (range (inc n)))]
    (* sum sum)))

(- (square-of-sum 100) (sum-of-squares 100))