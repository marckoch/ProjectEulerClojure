(ns math.divisors)

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

(divisors 24)

(defn proper-divisors 
  "Find all PROPER divisors of n (incl. 1 but excluding n itself)."
  [n]
  (remove #(= n %) (divisors n)))

(proper-divisors 220)