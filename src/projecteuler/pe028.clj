(ns projecteuler.pe028)

(defn diag-sum [k]
;;     // https://www.mathblog.dk/project-euler-28-sum-diagonals-spiral/
;;     // SUM(k) = (16*k^3 + 30k^2 + 26k )/3  +1
  (let [a (*' 16 k k k)
        b (*' 30 k k)
        c (*' 26 k)]
    (+' (/ (+' a b c) 3) 1))
  )

(defn solution []
  (let [n 1001
        k (- n 1)
        k (/ k 2)]
    (diag-sum k)))

(solution)