# binary-tree

[Weekly Programming Challenge #1](https://medium.com/@jamis/weekly-programming-challenge-1-55b63b9d2a1#.j3wnvtdko)

## Usage

Simple functions to work with a binary tree.

A tree is defines as a hash-map where each node is structured like:

```clojure
{:value 10
    :left  {:value 8 :left nil :right nil}
    :right {:value 12 :left nil :right nil}}
```

Create a tree:

``` clojure
(create-tree [3 5 2])

;;=> {:value 3,
    :left {:value 2, :left nil, :right nil},
    :right {:value 5, :left nil, :right nil}}
```

Inserting values:

``` clojure
(def tree (create-tree [3 5]))

(insert tree 10)

;;=>
{:value 3,
  :left nil,
  :right {:value 5, :left nil,
    :right {:value 10, :left nil, :right nil}}}

(-> tree
    (insert 10)
    (insert 1))

;;=>
{:value 3,
  :left {:value 1, :left nil, :right nil},
  :right {:value 5, :left nil,
    :right {:value 10, :left nil, :right nil}}}

```

Finding stuff:

``` clojure
(def tree (create-tree [3 5 2]))

(includes? tree 3) ;;=> true
(includes? tree 1) ;;=> false
```

Deleting nodes:

``` clojure
(def tree (create-tree [3 5 2]))

(delete tree 5)

;;=> {:value 3,
 :left {:value 2, :left nil, :right nil, :deleted? false},
 :right {:value 5, :left nil, :right nil, :deleted? true},
 :deleted? false}
```

Balance the tree (and remove any deleted nodes)

``` clojure
(normalize tree)

```

## To be done

* Balancing a tree
  * Automatically

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
