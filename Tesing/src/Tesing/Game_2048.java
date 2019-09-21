package Tesing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Game_2048 extends JPanel {
    enum State {
        start, won, running, over
    }
    final Color[] colorTable = {
            new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
            new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
            new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
            new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)};
    final static int target = 2048;
    static int highest;
    static int score;
    private Color gridColor = new Color(0xBBADA0);
    private Color emptyColor = new Color(0xCDC1B4);
    private Color startColor = new Color(0xFFEBCD);
    private Random rand = new Random();
    private Tile[][] tiles;
    private int side = 4;
    private State gamestate = State.start;
    private boolean checkingAvailableMoves;
    public Game_2048() {
        setPreferredSize(new Dimension(900, 700));
        setBackground(new Color(0xFAF8EF));
        setFont(new Font("SansSerif", Font.BOLD, 48));
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startGame();
                repaint();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight();
                        break;
                }
                repaint();
            }
        });
    }
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g);
    }
    void startGame() {//开始游戏
        if (gamestate != State.running) {//如果游戏状态不在运行中
            score = 0;
            highest = 0;
            gamestate = State.running;//将游戏状态修改为运行中
            tiles = new Tile[side][side];//创建一个方块组
            //产生两个随机方块
            addRandomTile();
            addRandomTile();
        }
    }
    void drawGrid(Graphics2D g) {//绘制初始面板
        g.setColor(gridColor);//设置颜色
        g.fillRoundRect(200, 100, 499, 499, 15, 15);//设置框选位置的颜色
        if (gamestate == State.running) {//如果游戏状态是在运行中
            //遍历方块组
            for (int r = 0; r < side; r++) {
                for (int c = 0; c < side; c++) {
                    if (tiles[r][c] == null) {//如果该方块为空
                        g.setColor(emptyColor);//设置空方块颜色
                        g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);//设置该位置（方块）颜色
                    } else {
                        drawTile(g, r, c);//调用该方块有值的绘制方法
                    }
                }
            }
        } else {
            g.setColor(startColor);//游戏开始时的颜色
            g.fillRoundRect(215, 115, 469, 469, 7, 7);//设置框选位置的颜色
            g.setColor(gridColor.darker());//字体颜色
            g.setFont(new Font("SansSerif", Font.BOLD, 128));//设置字体
            g.drawString("2048", 310, 270);//内容和位置
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            if (gamestate == State.won) {//如果游戏胜利
                g.drawString("you made it!", 390, 350);//胜利祝福语
            } else if (gamestate == State.over)//如果游戏失败
                g.drawString("game over", 400, 350);//提示游戏结束
            g.setColor(gridColor);
            //提示语
            g.drawString("click to start a new game", 330, 470);
            g.drawString("(use arrow keys to move tiles)", 310, 530);
        }
    }
    void drawTile(Graphics2D g, int r, int c) {//方块有值的绘制方块方法
        int value = tiles[r][c].getValue();//获取方块的值
        g.setColor(colorTable[(int) (Math.log(value) / Math.log(2)) + 1]);//设置方块的颜色
        g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);//设置该位置（方块）颜色
        String s = String.valueOf(value);//将值转为字符串
        g.setColor(value < 128 ? colorTable[0] : colorTable[1]);//根据值选取颜色范围
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int dec = fm.getDescent();
        //计算方块位置
        int x = 215 + c * 121 + (106 - fm.stringWidth(s)) / 2;
        int y = 115 + r * 121 + (asc + (106 - (asc + dec)) / 2);
        g.drawString(s, x, y);//在方块位置写上对应值
    }
    private void addRandomTile() {//添加随机方块
        int pos= rand.nextInt(side * side);//产生一个格子总数目以内的随机数
        int row, col;
        do {
            pos = (pos + 1) % (side * side);
            row = pos / side;//随机行
            col = pos % side;//随机列
        } while (tiles[row][col] != null);//当该位置方块为空的时候跳出循环
        int val = rand.nextInt(10) == 0 ? 4 : 2;//出现值为4方块的概率为10分之一，大部分都是出值为2的方块
        tiles[row][col] = new Tile(val);//设置新方块的值
    }
    private boolean move(int countDownFrom, int yIncr, int xIncr) {
        boolean moved = false;
        for (int i = 0; i < side * side; i++) {//遍历每个方块
            int j = Math.abs(countDownFrom - i);
            int r = j / side;
            int c = j % side;
            if (tiles[r][c] == null)//如果这个方块为空则直接进入下一次循环
                continue;
            int nextR = r + yIncr;//方块位置变动（根据输入的x，y值来进行变动）
            int nextC = c + xIncr;
            while (nextR >= 0 && nextR < side && nextC >= 0 && nextC < side) {//如果变动后的位置没有超出边界
                Tile next = tiles[nextR][nextC];//新建一个变动后的方块
                Tile curr = tiles[r][c];//变动前方块的值
                if (next == null) {//如果变动后的的值为空
                    if (checkingAvailableMoves)//检查是否可以继续移动
                        return true;
                    tiles[nextR][nextC] = curr;//变动后方块的值为变动前方块的值
                    tiles[r][c] = null;//原方块设为空
                    r = nextR;//当前块的坐标设为，变动后的坐标
                    c = nextC;
                    nextR += yIncr;//进行下一个块的移动
                    nextC += xIncr;
                    moved = true;
                } else if (next.canMergeWith(curr)) {//变动后的方块可与变动前方块混合（即值相等）
                    if (checkingAvailableMoves)
                        return true;
                    int value = next.mergeWith(curr);//将值设为混合后的值
                    if (value > highest)//如果大于最高分
                        highest = value;//更新最高分
                    score += value;//更新分数
                    tiles[r][c] = null;//原方块设为空
                    moved = true;
                    break;
                } else
                    break;
            }
        }
        if (moved) {
            if (highest < target) {//当前最高分小于目标分
                clearMerged();
                addRandomTile();//添加新的方块
                if (!movesAvailable()) {//如果不能继续移动
                    gamestate = State.over;//提示游戏结束
                }
            } else if (highest == target)//如果最高分等于目标分
                gamestate = State.won;//提示游戏胜利
        }
        return moved;
    }
    boolean moveUp() { return move(0, -1, 0); }
    boolean moveDown() {
        return move(side * side - 1, 1, 0);
    }
    boolean moveLeft() { return move(0, 0, -1);}
    boolean moveRight() { return move(side * side - 1, 0, 1); }
    void clearMerged() {//遍历所有方块
        for (Tile[] row : tiles)
            for (Tile tile : row)
                if (tile != null)//如果该位置方块不为空
                    tile.setMerged(false);//改变该位置状态
    }
    boolean movesAvailable() {
        checkingAvailableMoves = true;
        boolean hasMoves = moveUp() || moveDown() || moveLeft() || moveRight();//只要有一个方向可以移动
        checkingAvailableMoves = false;
        return hasMoves;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("2048");
            f.setResizable(true);
            f.add(new Game_2048(), BorderLayout.CENTER);//将之前绘制好的面板加到框架上
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
//方块
class Tile {
    private boolean merged;//判断方块是否为空
    private int value;//这个方块的值
    Tile(int val) {
        value = val;
    }
    int getValue() {
        return value;
    }
    void setMerged(boolean m) {
        merged = m;
    }
    boolean canMergeWith(Tile other) {//是否可以与其它方块融合
        return !merged && other != null && !other.merged && value == other.getValue();
    }
    int mergeWith(Tile other) {//融合后
        if (canMergeWith(other)) {
            value *= 2;//值翻倍
            merged = true;
            return value;
        }
        return -1;
    }
}