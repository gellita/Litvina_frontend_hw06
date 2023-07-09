package oop;
public class Rtriangle {
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;

   /* @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Rtriangle o = (Rtriangle) o;
        if (o!=this){
        return false;}
    }*/
        public double getPerimetr () {
            double len1 = Math.sqrt((x1 + x2) * (x1 + x2) + (y1 + y2) * (y1 + y2)); //правая сторона
            double len2 = Math.sqrt((x3 + x2) * (x3 + x2) + (y3 + y2) * (y3 + y2)); // левая сторона
            double len3 = Math.sqrt((x1 + x3) * (x1 + x3) + (y1 + y3) * (y1 + y3)); //основание
            return len1 + len2 + len3;
        }
        public double gerSquare () {
            int yh = y1;
            int xh = (x3 - x1) / 2;
            double len3 = Math.sqrt((x1 + x3) * (x1 + x3) + (y1 + y3) * (y1 + y3)); //основание
            double h = Math.sqrt((x2 + xh) * (x2 + xh) + (y2 + yh) * (y2 + yh)); // высота
            return h * len3 * 0.5;
        }



    public Rtriangle( int x1, int y1, int x2, int y2, int x3, int y3){
            this.x1 = x1; // 1,3 задают основание
            this.y1 = y1;
            this.x2 = x2; // 2 задает высоту
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;

        }

    }
