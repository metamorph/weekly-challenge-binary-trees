(ns binary-tree.core)

(defn create-node
  "Creates a stand-alone node with the supplied +value+."
  [value] {:value value :left nil :right nil :deleted? false})


(defn insert
  "Inserts a +value+ inte the tree with start from +node+.
  Returns a node with the value inserted."
  [node value]
  (let [current (:value node)]
    (cond
      (nil? node)       (create-node value)
      (< value current) (assoc node :left (insert (:left node) value))
      (> value current) (assoc node :right (insert (:right node) value))
      :else             (assoc node :deleted? false))))

(defn create-tree
  "Creates a binary tree where +values+ are inserted."
  [values] (reduce insert nil values))

(defn includes?
  "Checks if a value is included in the tree defined by +node+."
  [node value]
  (let [current (:value node)]
    (cond
      (nil? node)       false
      (= current value) (not (:deleted? node))
      (< value current) (includes? (:left node) value)
      (> value current) (includes? (:right node) value))))

(defn delete
  "Delete a value from the tree."
  [node value] node
  (let [current (:value node)]
    (cond
      (nil? node)       node
      (= current value) (assoc node :deleted? true)
      (< value current) (assoc node :left (delete (:left node) value))
      (> value current) (assoc node :right (delete (:right node) value)))))
