(ns projecteuler.pe031)

(defn range-incl [start end step]
  (range start (dec end) (- step)))

(count (for [a (range-incl 200 0 200)
             b (range-incl a 0 100)
             c (range-incl b 0 50)
             d (range-incl c 0 20)
             e (range-incl d 0 10)
             f (range-incl e 0 5)
             _ (range-incl f 0 2)]
         1))