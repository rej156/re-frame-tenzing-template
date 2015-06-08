(ns dissertation.components.next-page.view
  (:require [re-frame.core :refer [dispatch subscribe dispatch-sync]]))

(defn component []
  (let [x 1]
    (fn []
      [:div.next-page
       [:h1 "next-page"]
       [:a {:href "#/home"} "Click me to render the homepage!"]])))
