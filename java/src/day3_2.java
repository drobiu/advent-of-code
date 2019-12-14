import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3_2 {
    public static void main(String[] args) {
        Object[] commands = parse("src_3");

        ArrayList<String> firstLine = (ArrayList<String>) commands[0];
        ArrayList<String> secondLine = (ArrayList<String>) commands[1];

        int x = 0;
        int y = 0;
        int xold = 0;
        int yold = 0;

        ArrayList<Line> lines1 = new ArrayList<>();

        for (int i = 0; i < firstLine.size(); i++) {
            int num = Integer.parseInt(firstLine.get(i).substring(1));
            switch (firstLine.get(i).charAt(0)) {
                case 'U':
                    y += num;
                    lines1.add(new Line(xold, yold, x, y));
                    yold = y;
                    break;
                case 'D':
                    y -= num;
                    lines1.add(new Line(xold, yold, x, y));
                    yold = y;
                    break;
                case 'R':
                    x += num;
                    lines1.add(new Line(xold, yold, x, y));
                    xold = x;
                    break;
                case 'L':
                    x -= num;
                    lines1.add(new Line(xold, yold, x, y));
                    xold = x;
                    break;
            }
        }

        x = 0;
        y = 0;
        xold = 0;
        yold = 0;

        ArrayList<Line> lines2 = new ArrayList<>();

        for (int i = 0; i < secondLine.size(); i++) {
            int num = Integer.parseInt(secondLine.get(i).substring(1));
            switch (secondLine.get(i).charAt(0)) {
                case 'U':
                    y += num;
                    lines2.add(new Line(xold, yold, x, y));
                    yold = y;
                    break;
                case 'D':
                    y -= num;
                    lines2.add(new Line(xold, yold, x, y));
                    yold = y;
                    break;
                case 'R':
                    x += num;
                    lines2.add(new Line(xold, yold, x, y));
                    xold = x;
                    break;
                case 'L':
                    x -= num;
                    lines2.add(new Line(xold, yold, x, y));
                    xold = x;
                    break;
            }
        }

        ArrayList<Line> vert1 = new ArrayList<>();

        for (int i = 0; i < lines1.size(); i++) {
            if (lines1.get(i).isVertical) {
                vert1.add(lines1.get(i));
            }
        }

        ArrayList<Line> horiz1 = new ArrayList<>();

        for (int i = 0; i < lines1.size(); i++) {
            if (!lines1.get(i).isVertical) {
                horiz1.add(lines1.get(i));
            }
        }

        ArrayList<Line> vert2 = new ArrayList<>();

        for (int i = 0; i < lines2.size(); i++) {
            if (lines2.get(i).isVertical) {
                vert2.add(lines2.get(i));
            }
        }

        ArrayList<Line> horiz2 = new ArrayList<>();

        for (int i = 0; i < lines2.size(); i++) {
            if (!lines2.get(i).isVertical) {
                horiz2.add(lines2.get(i));
            }
        }

        ArrayList<Integer> xcross = new ArrayList<>();
        ArrayList<Integer> ycross = new ArrayList<>();

        int index1h = 0;
        int index1v = 0;
        Line h1 = null;
        Line v2 = null;

        outer: for (int i = 0; i < horiz1.size(); i++) {
            Line horizontal = horiz1.get(i);
            h1 = horizontal;
            int hx1 = horizontal.x1;
            int hx2 = horizontal.x2;
            if (hx1 > hx2) {
                int temp = hx1;
                hx1 = hx2;
                hx2 = temp;
            }
            for (int j = 0; j < vert2.size(); j++) {
                Line vertical = vert2.get(j);
                v2 = vertical;
                int vy1 = vertical.y1;
                int vy2 = vertical.y2;
                if (vy1 > vy2) {
                    int temp = vy1;
                    vy1 = vy2;
                    vy2 = temp;
                }
                if (vertical.x1 >= hx1 && vertical.x1 <= hx2 && horizontal.y1 >= vy1 && horizontal.y1 <= vy2) {
                    xcross.add(vertical.x1);
                    ycross.add(horizontal.y1);
                    index1h = i;
                    index1v = j;
                    break outer;
                }
            }
        }
        int index2h = 0;
        int index2v = 0;
        Line h2 = null;
        Line v1 = null;

        outer: for (int i = 0; i < horiz2.size(); i++) {
            Line horizontal = horiz2.get(i);
            h2 = horizontal;
            int hx1 = horizontal.x1;
            int hx2 = horizontal.x2;
            if (hx1 > hx2) {
                int temp = hx1;
                hx1 = hx2;
                hx2 = temp;
            }
            for (int j = 0; j < vert1.size(); j++) {
                Line vertical = vert1.get(j);
                v1 = vertical;
                int vy1 = vertical.y1;
                int vy2 = vertical.y2;
                if (vy1 > vy2) {
                    int temp = vy1;
                    vy1 = vy2;
                    vy2 = temp;
                }
                if (vertical.x1 >= hx1 && vertical.x1 <= hx2 && horizontal.y1 >= vy1 && horizontal.y1 <= vy2) {
                    xcross.add(vertical.x1);
                    ycross.add(horizontal.y1);
                    index2h = i;
                    index2v = j;
                    break outer;
                }
            }
        }

        int distance = 0;

        for (int i = 0; i < xcross.size(); i++) {

        }
        int i = 0;
        while (h1 != lines1.get(i)) {
            distance += lines1.get(i).length();
            i++;
        }
        i = 0;
        while (v2 != lines2.get(i)) {
            distance += lines2.get(i).length();
            i++;
        }

        System.out.println(distance);
    }



    public static Object[] parse(String file) {
        Scanner sc;
        String firstLine;
        String secondLine;
        ArrayList<String> moves1 = new ArrayList<>();
        ArrayList<String> moves2 = new ArrayList<>();

        Object[] commands = new Object[2];
        try {
            sc = new Scanner(new File(file));
            firstLine = sc.nextLine();
            secondLine = sc.nextLine();

            sc = new Scanner(firstLine);
            sc.useDelimiter(",");

            while (sc.hasNext()) {
                moves1.add(sc.next());
            }

            sc = new Scanner(secondLine);
            sc.useDelimiter(",");

            while (sc.hasNext()) {
                moves2.add(sc.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        commands[0] = moves1;
        commands[1] = moves2;

        return commands;
    }
}
