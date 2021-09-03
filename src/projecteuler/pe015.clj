(ns projecteuler.pe015
  (:require [math.factorial :as f]))

;; this is simple combinatorics
;; solution is
;; (20 + 20)!
;; ----------
;; 20! * 20!
;;
;; which can be reduced by canceling 20! on top and bottom:
;;
;; (40 * 30 * ... * 22 * 21)
;; -------------------------
;;       20!

(/ (f/factorial 20 40)
   (f/factorial 20))