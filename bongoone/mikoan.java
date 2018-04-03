package com.example.ednel.bongoone;

/**
 * Created by EdNel on 3/20/2018.
 */

public class mikoan{ private  int picha;
        private  String Tittle;
        private String stream;
        public mikoan(){


        }

        public mikoan(int picha,String Tittle,String stream){
            this.Tittle=Tittle;
            this.picha=picha;
            this.stream=stream;
        }

        public String getStream() {
            return stream;
        }

        public void setStream(String stream) {
            this.stream = stream;
        }

        public int getPicha() {
            return picha;

        }

        public void setTittle(String ttitle) {
            Tittle = ttitle;
        }

        public String getTittle() {
            return Tittle;
        }

        public void setPicha(int picha) {
            this.picha = picha;
        }


}
