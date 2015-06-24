(ns spike.handler
  (:use compojure.core)
  (:require
    [compojure.handler :as handler]
    [clojure.java.io :as io]
    [spike.document :as doc]
    [ring.middleware [multipart-params :as mp]]
    [hiccup.core :as h])
)

; (defn- str-to [num]
;   (apply str (interpose ", " (range 1 (inc num)))))

; (defn- str-from [num]
;   (apply str (interpose ", " (reverse (range 1 (inc num))))))

(defn- upload-template []
  (h/html
    [:h1 "Hello Word"]
    [:h2 "Select marketing data to upload"]
    [:form {:action "/upload" :method "post" :enctype "multipart/form-data"}
      [:label {:for "file"}
        "Data file to upload"
      ]
      [:br]
      [:input {:name "file" :type "file" :size "20"}]
      [:br]
      [:input {:type "submit" :name "submit" :value "Upload"}]]
  ))

(defn- upload-success [file]
  (h/html
    [:h1 "Upload success"]
    [:h2 "The document has been successfully uploaded."]
    [:pre file]
  ))

(defn- upload-file [file]
  ; (spike.document/data file)
  (upload-success file))

(defroutes app
  ; (GET "/count-up/:to" [to] (str-to (Integer. to)))
  ; (GET "/count-down/:from" [from] (str-from (Integer. from)))
  (GET "/upload" [] (upload-template))
  (mp/wrap-multipart-params
    (POST "/upload"
      {{{tempfile :tempfile filename :filename} :file} :params :as context}
      ; (io/copy tempfile (io/file "resources" "public" filename))
      (upload-file (apply str tempfile))
      ; (upload-file (apply str (get context :params)))
    )
  )
)
