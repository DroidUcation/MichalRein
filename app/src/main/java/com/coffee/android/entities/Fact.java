package com.coffee.android.entities;
/**
 * Created by michal_re on 06/05/2016.
 */
public class Fact {


        private int id;
        private String text;
        private String imageUrl;
        private String factName;

        public Fact() {
        }

        public Fact(String factName, String text) {
            this.text = text;
            this.factName = factName;
        }

        public String getFactName() {
            return factName;
        }

        public void setFactName(String factName) {
            this.factName = factName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

