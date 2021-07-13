public class MainLogic {
    public static void main(String[] args) {
        Plane plane = new Plane("Cessna 172",211,376,20);
        System.out.println(plane);
        plane.loadingAll();
        plane.move(new int[][]{{1,1},{100,700}});
        System.out.println(plane);

        System.out.println();

        Plane il78 = new Plane("Ил- 76",109_500,50_000,112);
        System.out.println(il78);
        il78.loadingAll();
        il78.move(new int[][]{{1,1},{100,2700}});
        System.out.println(il78);

        System.out.println();

        Plane altair = new HydroPlane("Бе-200 «Альтаир»",7_200,5_000,40);
        System.out.println(altair);
        altair.loadingAll();
        altair.move(new int[][]{{1,1},{100,2700}});
        System.out.println(altair);

//        Ship ship
    }
}
