package com.greenlist.graphs;

/**
 * You are given a dictionary of words and two strings, start and stop. All given strings have equal length.
 *
 * Transform string start to string stop one character per step using words from the dictionary. For example,
 * "abc" -> "abd" is a valid transformation step because only one character is changed (c->d) while "abc" ->
 * "axy" is not a valid step transformation because two characters are changed (b->x and c->y).
 *
 * You need to find the shortest possible sequence of strings (two or more) such that:
 *
 * First string is start.
 * Last string is stop.
 * Every string (except the first one) differs from the previous one by exactly one character.
 * Every string (except, possibly, first and last ones) are in the dictionary of words.
 * i.e. output = [start, <strings from="" the="" given="" dictionary="">, stop] and len(output) >= 2.</strings>
 *
 * If two or more such sequences exist, any one of them is a correct answer.
 *
 * If no such sequence is there to be found, [“-1”] (a sequence of one string, “-1”) is the correct answer.
 *
 * Example One
 * Input:
 * words = ["cat", "hat", "bad", "had"]
 * start = "bat"
 * stop = "had"
 * Output:
 * ["bat", "bad", "had"]
 * or
 * ["bat", "hat", "had"]
 *
 * From "bat" change character 't' to 'd', so new string will be "bad".
 *
 * From "bad" change character 'b' to 'h', so new string will be "had".
 *
 * or
 *
 * From "bat" change character 'b' to 'h', so new string will be "hat".
 *
 * From "hat" change character 't' to 'd', so new string will be "had".
 *
 * Example Two
 * Input:
 * words = []
 * start = bbb
 * stop = bbc
 * Output: ["bbb", "bbc"]
 * From "bbb" change the last character 'b' to 'c', so new string will be "bbc".
 *
 * Example Three
 * Input:
 * words = []
 * start = "zzzzzz"
 * stop = "zzzzzz"
 * Output: ["-1"]
 * Function must return an array of strings of length >= 2, where the first string is start and the last string is
 * stop, if the transformation is possible. Else return an array of strings containing only one string "-1", i.e.
 * return ["-1"].
 *
 * Here, the words dictionary is empty and ["zzzzzz", "zzzzzz"] is not a valid transformation hence return ["-1"].
 *
 * Example Four
 *
 * Input:
 *
 * words = ["cccw", "accc", "accw"]
 *
 * start = "cccc"
 *
 * stop = "cccc"
 *
 * Output:
 *
 * ["cccc", "cccw", "cccc"]
 *
 * Or:
 *
 * ["cccc", "accc", "cccc"]
 *
 *
 *
 * Notes
 *
 * Input Parameters:
 *
 * There are three arguments:
 *
 * Array of strings words,
 * String start,
 * String stop.
 * Output: Function must return an array of strings of length >= 2, where the first string is start and the last
 * string is stop, if the transformation is possible. Else return an array of strings containing only one string
 * "-1", i.e. return ["-1"].
 *
 * Constraints:
 * All input strings consist of lowercase Latin characters only.
 * 0 words combined
 * Dictionary words are not in any particular order, there may be duplicates, too.
 */
public class WordLadder
{
}
