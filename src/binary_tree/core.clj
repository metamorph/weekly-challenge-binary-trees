(ns binary-tree.core)

(defn create-node [value] {:value value
                           :left nil
                           :right nil})
(defn insert [node value]
  (let [current (:value node)]
    (cond
      (nil? node)       (create-node value)
      (< value current) (assoc node :left (insert (:left node) value))
      (> value current) (assoc node :right (insert (:right node) value))
      :else             node)))

(defn create-tree [values] (reduce insert nil values))

(defn includes? [node value]
  (let [current (:value node)]
    (cond
      (nil? node)       false
      (= current value) true
      (< value current) (includes? (:left node) value)
      (> value current) (includes? (:right node) value))))
