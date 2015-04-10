(ns dissertation.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [subscribe register-sub]]
            [dissertation.components.home.view :as home]
            [dissertation.components.next-page.view :as next-page]))

(defn error-page []
  [:div [:h1 "404"]])

(register-sub
 :component-to-render
 (fn [db _]
   (reaction
    (condp = (:component @db)
      :home home/component
      :next-page next-page/component
      (error-page)))))
