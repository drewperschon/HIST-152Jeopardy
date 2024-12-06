
package javaProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jeopardy extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 1000;
    private JPanel board;
    private JPanel info;
    private JButton[] myJeopardy;
    private JButton reset;
    private JLabel player1Wins;
    private JLabel player2Wins;
    private static String player1;
    private static String player2;
    private String answer;
    private static int p1Score;
    private static int p2Score;
    private int score;
    private int turn;

    public Jeopardy(Color theColor) {
        super("My First Jeopardy");
        this.setSize(1100, 1000);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout(5, 5));
        this.board = new JPanel(new GridLayout(7, 6, 15, 5));
        this.getContentPane().setBackground(Color.YELLOW);
        this.myJeopardy = new JButton[42];

        for(int i = 0; i < this.myJeopardy.length; ++i) {
            this.myJeopardy[i] = new JButton("" + i);
            this.categoryPics(i);
            if (i > 5) {
                this.myJeopardy[i].addActionListener(this);
            }

            this.myJeopardy[i].setSize(10, 10);
            this.categories(i);
            this.myJeopardy[i].setForeground(Color.BLACK);
            this.board.add(this.myJeopardy[i]);
        }

        this.add(this.board, "Center");
        this.info = new JPanel(new FlowLayout());
        this.reset = new JButton("RESET");
        this.reset.addActionListener(this);
        this.player1Wins = new JLabel(player1 + "'s Score: ");
        this.player2Wins = new JLabel(player2 + "'s Score: ");
        this.info.add(this.player1Wins);
        this.info.add(this.reset);
        this.info.add(this.player2Wins);
        this.add(this.info, "South");
    }

    public static void main(String[] args) {

        int input;
        do {
            input = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the post-World War II Jeopardy Game \n1. View the rules of the game \n2. Enter Player One and Player Two names \n3. Play the game! \n4. Exit Menu"));
            if (input == 1) {
                JOptionPane.showMessageDialog((Component)null, "1. This is a two player game. \n2. Must pick a category and a point value to play \n3. Click on the chosen box for the question. \n4. Correct responses must satisfy the demands of both the clue and the category. \n5. Responses must be spelled correctly " +
                        "\n6. Click the “Reset” button to start all over.\n7. Player with highest dollar amount at end of game wins.\n8. All questions will be over post-WWII America, including, but not limited to, the Red Scare, American Culture, Civil Rights, etc.\n9. Answers can be in lower or upper case.\n10. Have Fun!", "Rules of Jeopardy", 1);
            } else if (input == 2) {
                player1 = JOptionPane.showInputDialog("Enter Player One's name: ");
                player2 = JOptionPane.showInputDialog("Enter Player Two's name: ");
            } else if (input == 3) {
                while(player1 == null || player2 == null) {
                    JOptionPane.showMessageDialog((Component)null, "You didn't enter a name for Player One or Player Two. \nPlease enter names for Player One or Player Two: ");
                    player1 = JOptionPane.showInputDialog("Enter Player One's name: ");
                    player2 = JOptionPane.showInputDialog("Enter Player Two's name: ");
                }

                Jeopardy w = new Jeopardy(Color.RED);
                w.setVisible(true);
            }
        } while(input > 0 && input < 4);

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String actionCommand = e.getActionCommand();
        System.out.println("this is the item : " + actionCommand);
        if (actionCommand.equals("RESET")) {
            this.resetBoard();
        } else {
            int pos = Integer.parseInt(actionCommand);
            System.out.println(pos);
            if (this.turn % 2 == 0) {
                this.questions(pos, this.score);
                p1Score += this.score;
                this.player1Wins.setText(player1 + "'s Score: $" + p1Score);
                ++this.turn;
            } else if (this.turn % 2 == 1) {
                this.questions(pos, this.score);
                p2Score += this.score;
                this.player2Wins.setText(player2 + "'s Score: $" + p2Score);
                ++this.turn;
            }
        }

        this.winner();
    }

    public void winner() {
        if (!this.myJeopardy[6].isEnabled() && !this.myJeopardy[7].isEnabled() && !this.myJeopardy[8].isEnabled() && !this.myJeopardy[9].isEnabled() && !this.myJeopardy[10].isEnabled() && !this.myJeopardy[11].isEnabled() && !this.myJeopardy[12].isEnabled() && !this.myJeopardy[13].isEnabled() && !this.myJeopardy[14].isEnabled() && !this.myJeopardy[15].isEnabled() && !this.myJeopardy[16].isEnabled() && !this.myJeopardy[17].isEnabled() && !this.myJeopardy[18].isEnabled() && !this.myJeopardy[19].isEnabled() && !this.myJeopardy[20].isEnabled() && !this.myJeopardy[21].isEnabled() && !this.myJeopardy[22].isEnabled() && !this.myJeopardy[23].isEnabled() && !this.myJeopardy[24].isEnabled() && !this.myJeopardy[30].isEnabled() && !this.myJeopardy[36].isEnabled() && !this.myJeopardy[25].isEnabled() && !this.myJeopardy[31].isEnabled() && !this.myJeopardy[37].isEnabled() && !this.myJeopardy[26].isEnabled() && !this.myJeopardy[32].isEnabled() && !this.myJeopardy[38].isEnabled() && !this.myJeopardy[27].isEnabled() && !this.myJeopardy[33].isEnabled() && !this.myJeopardy[39].isEnabled() && !this.myJeopardy[28].isEnabled() && !this.myJeopardy[34].isEnabled() && !this.myJeopardy[40].isEnabled() && !this.myJeopardy[29].isEnabled() && !this.myJeopardy[35].isEnabled() && !this.myJeopardy[41].isEnabled()) {
            if (p1Score <= p2Score && p1Score < 14100) {
                if (p1Score < p2Score || p2Score >= 14100) {
                    JOptionPane.showMessageDialog((Component)null, player2 + " is the WINNER!!!", "Winner", 1);
                    this.disableButtons();
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, player1 + " is the WINNER!!!", "Winner", 1);
                this.disableButtons();
            }
        }

    }

    public int questions(int pos, int score) {
        switch (pos) {
            case 6:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>First name of senator who crusaded against Communism </html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Red Scare for $100 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("joseph")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Joseph (McCarthy)");
                    score = this.moneyWrong(pos);
                }
                break;
            case 7:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>A state that joined the U.S. in 1959 </html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture for $100 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("hawaii") || this.answer.equals("alaska")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Hawaii or Alaska");
                    score = this.moneyWrong(pos);
                }
                break;
            case 8:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>_____ Race: Name of competition between the U.S. and Soviet Union to achieve superior spaceflight capability</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture pt.2 for $100 \nWhat is the: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("space")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Space");
                    score = this.moneyWrong(pos);
                }
                break;
            case 9:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of British Prime Minister during world war II.</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("World for $100 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("churchill")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: (Winston) Churchill");
                    score = this.moneyWrong(pos);
                }
                break;
            case 10:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>First name of woman who refused to give up her seat on a public bus</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Civil Rights for $100 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("rosa")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Rosa (Parks)");
                    score = this.moneyWrong(pos);
                }
                break;
            case 11:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>38th ________: Korean peninsula is divided here</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Korean War for $100 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("parallel")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Parallel");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 12:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Senator McCarthy was from this state.");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Red Scare for $200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("wisconsin")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Wisconsin");
                    score = this.moneyWrong(pos);
                }
                break;
            case 13:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of the former president with the slogan 'I Like Ike.' </html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American culture for $200 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("eisenhower")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: (Dwight) Eisenhower");
                    score = this.moneyWrong(pos);
                }
                break;
            case 14:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Popular music machine found in most diners</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture pt.2 for $200 \nWhat is a: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("jukebox")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Jukebox");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 15:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Queen _________: became the Queen of the United Kingdom in 1952</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("World for $200 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("elizabeth")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Elizabeth");
                    score = this.moneyWrong(pos);
                }
                break;
            case 16:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>MLK's Bus Boycott took place in this city</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Civil Rights for $200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("montgomery")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Montgomery");
                    score = this.moneyWrong(pos);
                }
                break;
            case 17:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>The _________ War: A nickname for the Korean War</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Korean War for $200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("forgotten")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Forgotten");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 18:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>____ War: Name of tension period between the U.S. and Soviet Union</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Red Scare for $400 \nWhat is the: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("cold")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Cold");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 19:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>First name of Rock and Roll singer who sang 'Hound Dog'</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture for $400 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("elvis")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Elvis (Presley)");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 20:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>First name of singer who died in a plane crash in 1959</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture pt.2 for $400 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("buddy")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Buddy (Holly)");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 21:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>First name of leader who overthrew Fulgencio Batista's dictatorship</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("World for $400 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("fidel")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Fidel (Castro)");
                    score = this.moneyWrong(pos);
                }
                break;
            case 22:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>In 1957, the National Guard enforced a school in this state to be desegregated</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Civil Rights for $400 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("arkansas")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Arkansas (Little Rock)");
                    score = this.moneyWrong(pos);
                }
                break;
            case 23:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>This country was North Korea's main ally during the war</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Korean War for $400 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("china")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: China");
                    score = this.moneyWrong(pos);
                }
                break;
            case 24:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of leader of the Soviet Union until his death in 1953 </html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Red Scare for $800 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("stalin")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: (Joseph) Stalin");
                    score = this.moneyWrong(pos);
                }
                break;
            case 25:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Strategy used by Dwight Eisenhower: ______ Republicanism</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture for $800 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("modern")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Modern");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 26:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html> American ___: Name of song written by Don McLean</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Amerian Culture pt.2 for $800 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("pie")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Pie");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 27:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 10));
                this.myJeopardy[pos].setText("<html>____ Canal: Experienced fighting during 1956</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("World for $800 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("suez")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Suez");
                    score = this.moneyWrong(pos);
                }
                break;
            case 28:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of boy who was murdered in Mississippi for allegedly flirting with a white woman</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Civil Rights for $800 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("till")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: (Emmett) Till");
                    score = this.moneyWrong(pos);
                }
                break;
            case 29:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>An armistice was signed here, ending the war</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Korean War for $800 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("pyongyang")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Pyongyang");
                    score = this.moneyWrong(pos);
                }
                break;
            case 30:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>This industry took a huge hit during the Red Scare");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Red Scare for $1200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("film") || this.answer.equals("hollywood")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Hollywood (or Film)");
                    score = this.moneyWrong(pos);
                }
                break;
            case 31:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of actress and model who became an ultra popular sex symbol</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture for $1200 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("monroe")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: (Marilyn) Monroe");
                    score = this.moneyWrong(pos);
                }
                break;
            case 32:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of president who requested a bowling alley in the white house</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture pt.2 for $1200 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("truman")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: (Harry) Truman");
                    score = this.moneyWrong(pos);
                }
                break;
            case 33:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Name of the first satellite in Earth's orbit</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("World for $1200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("sputnik")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Sputnik");
                    score = this.moneyWrong(pos);
                }
                break;
            case 34:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>In 1960, Four Afican American college students refused to leave a lunch counter in this city</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Civil Rights for $1200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("greensboro")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Greensboro");
                    score = this.moneyWrong(pos);
                }
                break;
            case 35:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>An assault was launched here, pushing back North Korea and recapturing South Korea</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Korean War for $1200 \nWhat is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("inchon")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Inchon");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 36:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of the couple who were executed for spying for the Soviet Union </html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Red Scare for $2000 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("rosenberg")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Rosenberg");
                    score = this.moneyWrong(pos);
                }
                break;
            case 37:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of actor who starred in many western movies. Known as 'the Duke'</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture for $2000 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (!this.answer.equals("wayne")) {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: (John) Wayne");
                    score = this.moneyWrong(pos);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                }
                break;
            case 38:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Small candies, often used in dispensers, that were released in the 1950s</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("American Culture pt.2 for $2000\n What is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("pez")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG!\n Correct Answer: Pez");
                    score = this.moneyWrong(pos);
                }
                break;
            case 39:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>John F. Kennedy was assassinated in this brand of car.</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("World for $2000 \nWhat is a: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("lincoln")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Lincoln");
                    score = this.moneyWrong(pos);
                }
                break;
            case 40:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Last name of the person who assassinated Martin Luther King Jr.</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Civil Rights for $2000 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("ray")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: (James Earl) Ray");
                    score = this.moneyWrong(pos);
                }
                break;
            case 41:
                this.myJeopardy[pos].setFont(new Font("Arial", 1, 11));
                this.myJeopardy[pos].setText("<html>Syngman ____: The name of the ruler of the Southern half of the Korean Peninsula</html>");
                this.myJeopardy[pos].setEnabled(false);
                this.myJeopardy[pos].setBackground(Color.BLACK);
                this.myJeopardy[pos].setIcon((Icon)null);
                this.answer = JOptionPane.showInputDialog("Korean War for $2000 \nWho is: ");
                this.answer = this.answer.toLowerCase();
                if (this.answer.equals("rhee")) {
                    JOptionPane.showMessageDialog((Component)null, "CORRECT!");
                    score = this.money(pos);
                    System.out.println(score);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "WRONG! \n Correct Answer: Rhee");
                    score = this.moneyWrong(pos);
                }
        }

        return score;
    }

    public int money(int pos) {
        if (pos != 6 && pos != 7 && pos != 8 && pos != 9 && pos != 10 && pos != 11) {
            if (pos != 12 && pos != 13 && pos != 14 && pos != 15 && pos != 16 && pos != 17) {
                if (pos != 18 && pos != 19 && pos != 20 && pos != 21 && pos != 22 && pos != 23) {
                    if (pos != 24 && pos != 25 && pos != 26 && pos != 27 && pos != 28 && pos != 29) {
                        if (pos != 30 && pos != 31 && pos != 32 && pos != 33 && pos != 34 && pos != 35) {
                            if (pos == 36 || pos == 37 || pos == 38 || pos == 39 || pos == 40 || pos == 41) {
                                this.score = 1000;
                            }
                        } else {
                            this.score = 800;
                        }
                    } else {
                        this.score = 600;
                    }
                } else {
                    this.score = 400;
                }
            } else {
                this.score = 200;
            }
        } else {
            this.score = 100;
        }

        return this.score;
    }

    public int moneyWrong(int pos) {
        if (pos == 6 || pos == 7 || pos == 8 || pos == 9 || pos == 10 || pos == 11 || pos == 12 || pos == 13 || pos == 14 || pos == 15 || pos == 16 || pos == 17 || pos == 18 || pos == 19 || pos == 20 || pos == 21 || pos == 22 || pos == 23 || pos == 24 || pos == 25 || pos == 26 || pos == 27 || pos == 28 || pos == 29 || pos == 30 || pos == 31 || pos == 32 || pos == 33 || pos == 34 || pos == 35 || pos == 36 || pos == 37 || pos == 38 || pos == 39 || pos == 40 || pos == 41) {
            this.score = 0;
        }

        return this.score;
    }

    public void categories(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            if (i > 5 || i < 42) {
                this.myJeopardy[i].setBackground(Color.BLUE);
            }
        } else {
            this.myJeopardy[i].setBackground(Color.RED);
        }

    }

    public void categoryPics(int i) {
        switch (i) {
            case 0:
                this.myJeopardy[i].setText("Red Scare");
                break;
            case 1:
                this.myJeopardy[i].setText("American Culture");
                break;
            case 2:
                this.myJeopardy[i].setText("American Culture pt.2");
                break;
            case 3:
                this.myJeopardy[i].setText("World");
                break;
            case 4:
                this.myJeopardy[i].setText("Civil Rights");
                break;
            case 5:
                this.myJeopardy[i].setText("Korean War");
                break;
            case 6:
                ImageIcon image3 = new ImageIcon((new ImageIcon("src/Jeopardy images/harry/100.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image3);
                break;
            case 7:
                ImageIcon image9 = new ImageIcon((new ImageIcon("src/Jeopardy images/stars/100.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image9);
                break;
            case 8:
                ImageIcon image15 = new ImageIcon((new ImageIcon("src/Jeopardy images/disney/100.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image15);
                break;
            case 9:
                ImageIcon image21 = new ImageIcon((new ImageIcon("src/Jeopardy images/fast/100.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image21);
                break;
            case 10:
                ImageIcon image27 = new ImageIcon((new ImageIcon("src/Jeopardy images/ring/100.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image27);
                break;
            case 11:
                ImageIcon image33 = new ImageIcon((new ImageIcon("src/Jeopardy images/game/100.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image33);
                break;
            case 12:
                ImageIcon image4 = new ImageIcon((new ImageIcon("src/Jeopardy images/harry/200.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image4);
                break;
            case 13:
                ImageIcon image10 = new ImageIcon((new ImageIcon("src/Jeopardy images/stars/200.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image10);
                break;
            case 14:
                ImageIcon image16 = new ImageIcon((new ImageIcon("src/Jeopardy images/disney/200.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image16);
                break;
            case 15:
                ImageIcon image22 = new ImageIcon((new ImageIcon("src/Jeopardy images/fast/200.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image22);
                break;
            case 16:
                ImageIcon image28 = new ImageIcon((new ImageIcon("src/Jeopardy images/ring/200.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image28);
                break;
            case 17:
                ImageIcon image34 = new ImageIcon((new ImageIcon("src/Jeopardy images/game/200.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image34);
                break;
            case 18:
                ImageIcon image5 = new ImageIcon((new ImageIcon("src/Jeopardy images/harry/300.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image5);
                break;
            case 19:
                ImageIcon image11 = new ImageIcon((new ImageIcon("src/Jeopardy images/stars/300.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image11);
                break;
            case 20:
                ImageIcon image17 = new ImageIcon((new ImageIcon("src/Jeopardy images/disney/300.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image17);
                break;
            case 21:
                ImageIcon image23 = new ImageIcon((new ImageIcon("src/Jeopardy images/fast/300.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image23);
                break;
            case 22:
                ImageIcon image29 = new ImageIcon((new ImageIcon("src/Jeopardy images/ring/300.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image29);
                break;
            case 23:
                ImageIcon image35 = new ImageIcon((new ImageIcon("src/Jeopardy images/game/300.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image35);
                break;
            case 24:
                ImageIcon image6 = new ImageIcon((new ImageIcon("src/Jeopardy images/harry/400.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image6);
                break;
            case 25:
                ImageIcon image12 = new ImageIcon((new ImageIcon("src/Jeopardy images/stars/400.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image12);
                break;
            case 26:
                ImageIcon image18 = new ImageIcon((new ImageIcon("src/Jeopardy images/disney/400.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image18);
                break;
            case 27:
                ImageIcon image24 = new ImageIcon((new ImageIcon("src/Jeopardy images/fast/400.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image24);
                break;
            case 28:
                ImageIcon image30 = new ImageIcon((new ImageIcon("src/Jeopardy images/ring/400.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image30);
                break;
            case 29:
                ImageIcon image36 = new ImageIcon((new ImageIcon("src/Jeopardy images/game/400.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image36);
                break;
            case 30:
                ImageIcon image7 = new ImageIcon((new ImageIcon("src/Jeopardy images/harry/500.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image7);
                break;
            case 31:
                ImageIcon image13 = new ImageIcon((new ImageIcon("src/Jeopardy images/stars/500.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image13);
                break;
            case 32:
                ImageIcon image19 = new ImageIcon((new ImageIcon("src/Jeopardy images/disney/500.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image19);
                break;
            case 33:
                ImageIcon image25 = new ImageIcon((new ImageIcon("src/Jeopardy images/fast/500.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image25);
                break;
            case 34:
                ImageIcon image31 = new ImageIcon((new ImageIcon("src/Jeopardy images/ring/500.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image31);
                break;
            case 35:
                ImageIcon image37 = new ImageIcon((new ImageIcon("src/Jeopardy images/game/500.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image37);
                break;
            case 36:
                ImageIcon image8 = new ImageIcon((new ImageIcon("src/Jeopardy images/harry/600.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image8);
                break;
            case 37:
                ImageIcon image14 = new ImageIcon((new ImageIcon("src/Jeopardy images/stars/600.png")).getImage().getScaledInstance(190, 130, 1));
                this.myJeopardy[i].setIcon(image14);
                break;
            case 38:
                ImageIcon image20 = new ImageIcon((new ImageIcon("src/Jeopardy images/disney/600.png")).getImage().getScaledInstance(180, 130, 1));
                this.myJeopardy[i].setIcon(image20);
                break;
            case 39:
                ImageIcon image26 = new ImageIcon((new ImageIcon("src/Jeopardy images/fast/600.png")).getImage().getScaledInstance(180, 130, 1));
                this.myJeopardy[i].setIcon(image26);
                break;
            case 40:
                ImageIcon image32 = new ImageIcon((new ImageIcon("src/Jeopardy images/ring/600.png")).getImage().getScaledInstance(180, 130, 1));
                this.myJeopardy[i].setIcon(image32);
                break;
            case 41:
                ImageIcon image38 = new ImageIcon((new ImageIcon("src/Jeopardy images/game/600.png")).getImage().getScaledInstance(180, 130, 1));
                this.myJeopardy[i].setIcon(image38);
        }

    }

    public void resetBoard() {
        for(int i = 0; i < this.myJeopardy.length; ++i) {
            this.myJeopardy[i].setEnabled(true);
            this.myJeopardy[i].setText("" + i);
            this.categories(i);
            this.categoryPics(i);
            this.myJeopardy[i].setForeground(Color.BLACK);
            p1Score = 0;
            p2Score = 0;
            this.player1Wins.setText(player1 + "'s Score: " + p1Score);
            this.player2Wins.setText(player2 + "'s Score: " + p2Score);
        }

    }

    public void disableButtons() {
        for(int i = 0; i < this.myJeopardy.length; ++i) {
            this.myJeopardy[i].setEnabled(false);
            this.myJeopardy[i].setText("" + i);
            this.categories(i);
            this.categoryPics(i);
            this.myJeopardy[i].setForeground(Color.BLACK);
        }

    }
}
