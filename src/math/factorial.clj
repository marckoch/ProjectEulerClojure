(ns math.factorial)

(defn factorial
  "Multiply from 1 to 'to' or from 'from' to 'to' :-)"
  ([to]  (factorial 1 to))
  ([from to] (reduce *' (range from to))))

(factorial 20)