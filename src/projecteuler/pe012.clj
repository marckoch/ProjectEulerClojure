(ns projecteuler.pe012)

(defn positive-numbers
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(take 10 (positive-numbers))

(defn triangular 
  "Calculate the n-th triangular number."
  [n]
  (/ (* n (+ n 1)) 2))

(defn triangular-numbers
  "Generate triangular numbers: 1, 3, 6, 10, 15, ..."
  ([]  (triangular-numbers 1))
  ([n] (lazy-seq (cons (triangular n) (triangular-numbers (inc n))))))

(take 15 (triangular-numbers))

(defn divisors
  "Find ALL divisors of n (incl. 1 and n itself)."
  [n]
  (let [limit (inc (Math/sqrt n))]
    (->>
     (range 1 limit)
     (filter #(zero? (rem n %)))
     (map #(vector (/ n %) %))
     flatten
     set
     sort)))

(divisors 11253321)

(time
 (->>
  (triangular-numbers)
  (drop-while #(> 500 (count (divisors %))))
  first))