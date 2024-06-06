package model.pieces;

/**
 * Used to differentiate between native pieces to player's board vs 
 * pieces that are sent over from another player 
 */
public enum PieceType {
    PLAYER, SENT, RECEIVED; 
}
