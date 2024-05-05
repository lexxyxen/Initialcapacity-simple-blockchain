package io.collective.basic;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private final List<Block> blocksArrList = new ArrayList<>();

    public boolean isEmpty() {
        return blocksArrList.isEmpty();
    }

    public void add(Block block) {
        blocksArrList.add(block);
    }

    public int size() {
        return blocksArrList.size();
    }

    public boolean isValid() throws NoSuchAlgorithmException {

        // todo - check mined

        // todo - check previous hash matches

        // todo - check hash is correctly calculated


        return false;
    }

    /// Supporting functions that you'll need.

    public static Block mine(Block block) throws NoSuchAlgorithmException {
        Block mined = new Block(block.getPreviousHash(), block.getTimestamp(), block.getNonce());

        while (!isMined(mined)) {
            mined = new Block(mined.getPreviousHash(), mined.getTimestamp(), mined.getNonce() + 1);
        }
        return mined;
    }

    public static boolean isMined(Block minedBlock) {
        return minedBlock.getHash().startsWith("00");
    }
}