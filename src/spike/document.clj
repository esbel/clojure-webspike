(ns spike.document
  (:use dk.ative.docjure.spreadsheet)
  )

(defn data [file]
  (load-workbook file)
  (select-sheet "Price List")
  (select-columns {:A :name, :B :price})
)
