import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardGame2 {

    static int score = 15;

    static String players_Card_Suit = "";
    static String players_Card_Number = "";

    static String players_Card = "";

    static String computers_Card_Suit = "";
    static String computers_Card_Number = "";

    static String computers_Card = "";




    public static void main(String[] args) {
        JFrame frame = new JFrame("CardGame");


        //Score Label

        JLabel scoreLabel = new JLabel("Your Score: " + score);

        scoreLabel.setFont(new Font("sherif",Font.BOLD,16));

        scoreLabel.setForeground(Color.BLUE);

        scoreLabel.setBounds(120,10,150,30);




        //CardNumber in combobox

        String[] cardNumber = {"ace","2","3","4","5","6","7","8","9","10","jack","king","queen"};

        JComboBox comboBox = new JComboBox<>(cardNumber);

        comboBox.setBounds(40,50,100,30);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players_Card_Number += comboBox.getItemAt(comboBox.getSelectedIndex());
            }
        });

        //Card suits in checkbox group

        JCheckBox club = new JCheckBox("Club");
        JCheckBox spade = new JCheckBox("Spade");
        JCheckBox diamond = new JCheckBox("Diamond");
        JCheckBox heart = new JCheckBox("Heart");


        club.setBounds(150,50,90,30);
        spade.setBounds(230,50,90,30);
        diamond.setBounds(150,70,90,30);
        heart.setBounds(230,70,90,30);


        ButtonGroup group = new ButtonGroup();

        group.add(club);
        group.add(spade);
        group.add(diamond);
        group.add(heart);

        club.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players_Card_Suit += "c";
            }
        });

        spade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players_Card_Suit += "s";
            }
        });

        diamond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players_Card_Suit += "d";
            }
        });

        heart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players_Card_Suit += "h";
            }
        });


        //Image

        JLabel cardOfPlayer = new JLabel("Players card:");
        JLabel cardofComputer = new JLabel("Computers card: ");

        cardOfPlayer.setBounds(100,120,100,30);
        cardofComputer.setBounds(200,120,150,30);


        ImageIcon back1 = new ImageIcon("src/Cards-20221209/back.jpg");
        ImageIcon back2 = new ImageIcon("src/Cards-20221209/back.jpg");

        JLabel imageBack1 = new JLabel(back1);
        JLabel imageBack2 = new JLabel(back2);

        imageBack1.setBounds(100,150,100,100);
        imageBack2.setBounds(200,150,100,100);

        //Adding check button

        JButton check = new JButton("Check");

        check.setBounds(150,270,100,50);




        //Changing players card Image


        check.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                players_Card = players_Card_Number + players_Card_Suit;
                String lala = "src/Cards-20221209/%s.jpg";
                String lala2 = String.format(lala,players_Card);
                ImageIcon player = new ImageIcon(lala2);
                imageBack1.setIcon(player);


                // Computer choose the card

                Random random = new Random();
                int computersNumber = random.nextInt(cardNumber.length);
                computers_Card_Number += cardNumber[computersNumber];

                int computersSuit = random.nextInt(4);
                if (computersSuit == 0){
                    computers_Card_Suit += "c";
                }else if (computersSuit == 1){
                    computers_Card_Suit += "s";
                }
                else if (computersSuit == 2){
                    computers_Card_Suit += "d";
                }
                else if (computersSuit == 3){
                    computers_Card_Suit += "h";
                }

                computers_Card = computers_Card_Number + computers_Card_Suit;
                String baba = "src/Cards-20221209/%s.jpg";
                String baba2 = String.format(baba,computers_Card);
                ImageIcon computer = new ImageIcon(baba2);
                imageBack2.setIcon(computer);

                
                if (computers_Card_Number.equals(players_Card_Number) && computers_Card_Suit.equals(players_Card_Suit)){
                    score += 10;
                    scoreLabel.setText("Your score: " + score);

                }
                else if (computers_Card_Suit.equals(players_Card_Suit)) {
                    score += 3;
                    scoreLabel.setText("Your score: " + score);
                }
                else if (computers_Card_Number.equals(players_Card_Number)) {
                    score += 5;
                    scoreLabel.setText("Your score: " + score);
                }
                else {
                    score -=1;
                    scoreLabel.setText("Your Score: " + score);
                }

                if (score >= 25){
                    scoreLabel.setText("Players win!!");
                } else if (score <= 0) {
                    scoreLabel.setText("Players lose!!");
                }


                players_Card ="";
                players_Card_Suit = "";
                players_Card_Number ="";
                computers_Card ="";
                computers_Card_Number = "";
                computers_Card_Suit = "";
            }

        });




        //Adding Component to the frame
        frame.add(comboBox);
        frame.add(club);
        frame.add(spade);
        frame.add(diamond);
        frame.add(heart);
        frame.add(scoreLabel);
        frame.add(cardofComputer);
        frame.add(cardOfPlayer);
        frame.add(imageBack1);
        frame.add(imageBack2);
        frame.add(check);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
