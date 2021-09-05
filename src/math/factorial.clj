(ns math.factorial)

(defn factorial
  "Multiply from 1 to 'to' (inclusive) or 
   from 'from' to 'to' (both inclusive) :-)
   
   = from * (from+1) * ... * (to-1) * to
   e.g.
   (factorial 4) = 1 * 2 * 3 * 4 = 24
   (factorial 3 5) = 3 * 4 * 5 = 60"
  ([to]  (factorial 1 to))
  ([from to] (reduce *' (range from (inc to)))))

(factorial 4)

(factorial 3 5)