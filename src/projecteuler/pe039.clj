(ns projecteuler.pe039)

(defn pythagorean-triples 
  "Produce a list of pythagorean triplets up to 'limit' (excluding).
   Each triplet is a vector of 3 numbers where first^2 + second^2 = third^2,
   e.g. [3 4 5], [5 12 13], ..."
  [limit]
(for [a (range 1 limit)
      b (range a limit)
      c (range b limit)
      :when (= (+ (* a a) (* b b))
               (* c c))]
  (vector a b c))  )

(pythagorean-triples 21)

(->> (pythagorean-triples 501)
     (group-by #(reduce + %))
     (apply max-key #(count (val %)))
     key)

; alternative:
(->> (pythagorean-triples 501)
     (map #(reduce + %))
     frequencies
     (apply max-key val)
     key)