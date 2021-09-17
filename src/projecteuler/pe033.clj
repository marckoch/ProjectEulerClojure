(ns projecteuler.pe033)

;; case 1: we cancel the leading digit
;; 10*x + y   y
;; -------- = -
;; 10*x + z   z
(defn check-case1 [x y]
  (for [z (range (inc y) 10)
        :when (= (* z (+ y (* 10 x)))
                 (* y (+ z (* 10 x))))]
    (/ y z)))

;; case 2: we cancel the last digit
;; 10*x + y   x
;; -------- = -
;; 10*z + y   z
(defn check-case2 [x y]
  (for [z (range (inc x) 10)
        :when (= (* z (+ y (* 10 x)))
                 (* x (+ y (* 10 z))))]
    (/ x z)))

;; case 3: we cancel the top leading digit with the bottom right digit
;; 10*x + y   y
;; -------- = -
;; 10*z + x   z
(defn check-case3 [x y]
  (for [z (range (inc y) 10)
        :when (= (* z (+ y (* 10 x)))
                 (* y (+ x (* 10 z))))]
    (/ y z)))

;; case 4: we cancel the top right digit with the bottom left digit
;; 10*x + y   x
;; -------- = -
;; 10*y + z   z
(defn check-case4 [x y]
  (for [z (range (inc x) 10)
        :when (= (* z (+ y (* 10 x)))
                 (* x (+ z (* 10 y))))]
    (/ x z)))

(->>
 (for [x (range 1 10)
       y (range 1 10)]
   (concat (check-case1 x y)
           (check-case2 x y)
           (check-case3 x y)
           (check-case4 x y)))
 distinct
 flatten
 (reduce *))