(ns projecteuler.pe009)

(defn pythagorean? 
  "Check if a b c form a phytagorean triangle.
   That means check if a^2 + b^2 = c^2."
  [a b c]
  (= (+ (* a a) (* b b))
     (* c c)))

(comment
  (pythagorean? 3 4 5)

  (pythagorean? 3 4 6))

;; no side can be longer than half of the sum of all sides
(def limit (/ 1000 2))

(for [a (range limit)
      b (range a limit)
      :let [c (- 1000 a b)]
      :when (pythagorean? a b c)]
  (* a b c))