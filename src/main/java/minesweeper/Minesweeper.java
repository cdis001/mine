package minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Minesweeper extends JFrame {

  int[][] mineArr = new int[10][10];
  Random random = new Random();
  JPanel jp = new JPanel();
  JButton[][] button = new JButton[10][10];

  public void makeMine() {

    this.setTitle("지뢰찾기");
    this.add(jp);

    // 지뢰 설정
    for(; ; ) {
      for(int row, col, count = 0; count < 10;) {
        row = random.nextInt(10);
        col = random.nextInt(10);

        if(mineArr[row][col] != -1) {
          mineArr[row][col] = -1;
          count++;
        }
      }
      break;
    }

    // 10 * 10 버튼 생성
    for(int row = 0; row < 10; row++) {
      for(int col = 0; col < 10; col++) {
        button[row][col] = new JButton("");
        button[row][col].setPreferredSize(new Dimension(20, 20));
        button[row][col].addActionListener(new LClickListener());
        jp.add(button[row][col]);
      }
    }

    // 버튼 숫자 검사
    for(int row = 0; row < 10; row++) {
      for(int col = 0; col < 10; col++) {
        int mineCount = 0;
        if(mineArr[row][col] != -1) {
          if(row >= 0 && col >= 0 && row <= 10 && col <= 10) {
            if(row - 1 >= 0 && col - 1 >= 0)
            if(mineArr[row - 1][col - 1] == -1) mineCount++;

            if(row - 1 >= 0)
            if(mineArr[row - 1][col] == -1) mineCount++;

            if(row - 1 >= 0 && col + 1 <= 9)
            if(mineArr[row - 1][col + 1] == -1) mineCount++;

            if(col - 1 >= 0)
            if(mineArr[row][col - 1] == -1) mineCount++;

            if(col + 1 <= 9)
            if(mineArr[row][col + 1] == -1) mineCount++;

            if(row + 1 <= 9 && col - 1 >= 0)
            if(mineArr[row + 1][col - 1] == -1) mineCount++;

            if(row + 1 <= 9)
            if(mineArr[row + 1][col] == -1) mineCount++;

            if(row + 1 <= 9 && col + 1 <= 9)
            if(mineArr[row + 1][col + 1] == -1) mineCount++;
          }
          mineArr[row][col] = mineCount;
        }
        mineCount = 0;
      }
    }

    this.setSize(280, 300);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);


  }

  // 좌클릭 이벤트
  private class LClickListener implements ActionListener  {

    @Override
    public void actionPerformed(ActionEvent e) {
      for(int row = 0; row < 10; row++) {
        for(int col = 0; col < 10; col++) {
          if(e.getSource() == button[row][col] && mineArr[row][col] != -1) {
            if(button[row][col].isBorderPainted() == true) {

              switch(mineArr[row][col]) {
                case 0:
                  button[row][col].setText("0");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 1:
                  button[row][col].setText("1");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 2:
                  button[row][col].setText("2");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 3:
                  button[row][col].setText("3");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 4:
                  button[row][col].setText("4");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 5:
                  button[row][col].setText("5");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 6:
                  button[row][col].setText("6");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 7:
                  button[row][col].setText("7");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;

                case 8:
                  button[row][col].setText("8");
                  button[row][col].setBorderPainted(false);
                  button[row][col].setContentAreaFilled(false);
                  button[row][col].setFocusPainted(false);
                  break;
              }
            }
          }

          if(e.getSource() == button[row][col] && mineArr[row][col] == -1) {
            button[row][col].setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "BOOM!");
          }
        }
      }
    }

  }

  public static void main(String[] args) {

    Minesweeper minesweeper = new Minesweeper();
    minesweeper.makeMine();


  }
}
