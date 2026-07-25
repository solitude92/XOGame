package com.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Activity for Tic Tac Toe Android Game
 * Converted from console-based XO game
 */
public class MainActivity extends AppCompatActivity {

    private Button[] buttons = new Button[9];
    private TextView statusText;
    private TextView player1Name;
    private TextView player2Name;
    
    private Player player1;
    private Player player2;
    private boolean player1Turn = true;
    private boolean gameActive = false;
    
    private Marble xMarble;
    private Marble oMarble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize marbles
        xMarble = new Marble("X");
        oMarble = new Marble("O");
        
        // Initialize UI elements
        statusText = findViewById(R.id.statusText);
        player1Name = findViewById(R.id.player1Name);
        player2Name = findViewById(R.id.player2Name);
        
        // Initialize buttons
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        
        // Set click listeners
        for (int i = 0; i < 9; i++) {
            final int index = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleButtonClick(index);
                }
            });
        }
        
        // Start new game
        startNewGame();
    }
    
    private void startNewGame() {
        // Reset the game board
        PlaygroundXOGame.reset();
        
        // Create players
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        
        // Assign marbles (Player 1 chooses first in original, here we auto-assign)
        player1.type = xMarble;
        player2.type = oMarble;
        
        // Reset turn
        player1Turn = true;
        gameActive = true;
        
        // Update UI
        updatePlayerNames();
        updateStatus();
        
        // Clear all buttons
        for (Button button : buttons) {
            button.setText("");
            button.setEnabled(true);
            button.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        }
    }
    
    private void handleButtonClick(int position) {
        if (!gameActive) return;
        
        Player currentPlayer = player1Turn ? player1 : player2;
        
        // Try to insert the move
        if (PlaygroundXOGame.insert(position, currentPlayer)) {
            // Update button text
            buttons[position].setText(currentPlayer.type.type);
            
            // Check for winner
            if (PlaygroundXOGame.winner(currentPlayer)) {
                gameActive = false;
                showWinnerDialog(currentPlayer);
                disableAllButtons();
                return;
            }
            
            // Check for draw
            if (PlaygroundXOGame.isFull()) {
                gameActive = false;
                showDrawDialog();
                disableAllButtons();
                return;
            }
            
            // Switch turn
            player1Turn = !player1Turn;
            updateStatus();
        } else {
            Toast.makeText(this, "Cell already taken!", Toast.LENGTH_SHORT).show();
        }
    }
    
    private void updateStatus() {
        Player currentPlayer = player1Turn ? player1 : player2;
        statusText.setText("Current Turn: " + currentPlayer.name + " (" + currentPlayer.type.type + ")");
    }
    
    private void updatePlayerNames() {
        player1Name.setText(player1.name + " (X)");
        player2Name.setText(player2.name + " (O)");
    }
    
    private void disableAllButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }
    
    private void showWinnerDialog(Player winner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over")
               .setMessage(winner.name + " is the winner! 🎉\nCONGRATULATIONS!")
               .setPositiveButton("Play Again", (dialog, which) -> startNewGame())
               .setNegativeButton("Exit", (dialog, which) -> finish())
               .show();
    }
    
    private void showDrawDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over")
               .setMessage("It's a Draw! 🤝")
               .setPositiveButton("Play Again", (dialog, which) -> startNewGame())
               .setNegativeButton("Exit", (dialog, which) -> finish())
               .show();
    }
}
