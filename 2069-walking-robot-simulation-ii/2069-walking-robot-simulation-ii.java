class Robot {
    int x = 0, y = 0;
    int w, h;
    int dir = 0; // 0=East, 1=North, 2=West, 3=South
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public Robot(int width, int height) {
        w = width;
        h = height;
    }
    
    public void step(int num) {
    if (w == 1 && h == 1) return;

    int perimeter = 2 * (w + h - 2);
    num = num % perimeter;

    if (num == 0) num = perimeter;

    while (num > 0) {
        int steps = 0;

        if (dir == 0) steps = w - 1 - x;
        else if (dir == 1) steps = h - 1 - y;
        else if (dir == 2) steps = x;
        else steps = y;

        if (steps >= num) {
            x += dx[dir] * num;
            y += dy[dir] * num;
            num = 0;
        } else {
            x += dx[dir] * steps;
            y += dy[dir] * steps;
            num -= steps;
            dir = (dir + 1) % 4;
        }
    }
}
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}