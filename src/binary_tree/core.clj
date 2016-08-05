(ns binary-tree.core)

(defn create-node
  "Creates a stand-alone node with the supplied +value+."
  [value] {:value value
                           :left nil
                           :right nil})
(defn insert
  "Inserts a +value+ inte the tree with start from +node+.
  Returns a node with the value inserted."
  [node value]
  (let [current (:value node)]
    (cond
      (nil? node)       (create-node value)
      (< value current) (assoc node :left (insert (:left node) value))
      (> value current) (assoc node :right (insert (:right node) value))
      :else             node)))

(defn create-tree
  "Creates a binary tree where +values+ are inserted."
  [values] (reduce insert nil values))

(defn includes?
  "Checks if a value is included in the tree defined by +node+."
  [node value]
  (let [current (:value node)]
    (cond
      (nil? node)       false
      (= current value) true
      (< value current) (includes? (:left node) value)
      (> value current) (includes? (:right node) value))))
