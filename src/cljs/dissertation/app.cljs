(ns dissertation.app
  (:require [re-frame.core :refer [dispatch subscribe dispatch-sync]]
            [reagent.core :as reagent :refer [atom]]
            [dissertation.handlers]
            [dissertation.subs]
            [dissertation.routes :refer [init-routes]]))

(defn my-component []
  (let [component (subscribe [:component-to-render])]
    (fn []
      (let [deref-component @component]
        [:div.container
         [:h1 {:on-click #(dispatch [:render-component :next-page])}"Change page"]
         [:a {:href "#/next-page"} "Click me!"]
         [:h1 (str "This is my let ")]
         (if deref-component
           [deref-component]
           [:h1 "404"])
         ])
      )))

(defn calling-component []
  (reagent/create-class
   {:component-will-mount #(init-routes)
    :reagent-render #(my-component)}))

(defn init []
  (dispatch-sync [:initialise-db])
  (reagent/render-component [calling-component]
                            (.getElementById js/document "app")))
