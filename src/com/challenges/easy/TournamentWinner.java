package com.challenges.easy;

import java.util.ArrayList;
import java.util.Hashtable;

/*
 * 
	Tournament Winner
	
	There's an algorithm tournament taking place in which teams of programmers compete against each other to solve algorithmic problems as fast as possible.
	Teams compete in a round robin, where each team faces off against all other teams. Only two teams compete against each other at a time, and for each competition,
	one team is designated the 'home team', while the other team is the 'away team'. In each competition there;s always one winner and one loser; there are no ties.
	A team receives 3 points if it wins and 0 points if it loses. The winner of the tournament is the team that receives the most amount of points.
	
	Given an array of pairs representing the teams that have competed against each other and an array containing the results of each competition, write a function that
	returns the winners of the tournament. The input arrays are name 'competitions' and 'results', respectively. 
	
	The 'competition' array has elements in the form of '[homeTeam, awayTeam]', where each team is a string of at most 30 characters representing the name of the team.
	The 'results' array contains information about the winner of each corresponding competition in the 'competitions' array. Specifically, 'results[i]' denotes the winner of
	'competitions[i]', where a 1 in the 'results' array means that the home team in the corresponding competition won and a 0 means the away team won.
	
	It's guaranteed that exactly one team will win the tournament and that each team will compete against all other teams exactly once. It's also guaranteed that the tournament
	will always have at least 2 teams.
	
	Sample Input:
	competitions = [
		["HTML", "C#"],
		["C#", "Python"],
		["Python", "HTML"]
	]
	results = [0, 0, 1]
	
	Sample Output:
	"Python" 
 * 
 */

public class TournamentWinner {

	public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

		// 1. We create 3 variables: (1) A Hashtable to hold our winners and their scores, (2) the highest scoring team, and (3) the highest score. 
		Hashtable<String, Integer> winners = new Hashtable<String, Integer>();
		String highestScorer = "";
		Integer highScore = 0;
		
		
		// 2. We create a 'for' loop to iterate over our arraylist of competitions, with each value of 'i' representing a single round of competition.
		for(int i = 0; i < competitions.size(); i++) {
			
			// 3. We create a variable to hold the current winner at index 'i'
			String winner = "";
			
			// 4. If the home team (1) won the round at 'i' in the 'results' arraylist...
			if(results.get(i) == 1) {
				
				// ...then we set the winner equal to the home team.
				winner = competitions.get(i).get(0);
			
			// 5. If the winning team was not the home team...	
			} else {
				
				// ...then we repeat the same process, just with the away team.
				winner = competitions.get(i).get(1);
			}
			
			// 6. We then check our hashtable to see if that winner has already been entered in as a key. If it has...
			if(winners.containsKey(winner)) {
				
				// ...we create a variable to store the score, which would be the value of the key...
				int score = winners.get(winner);
				
				//...then create a variable that adds 3 to that score (since each winner receives 3 points)...
				int newScore = score + 3;
				
				//...and replace the old score value with the updated score in the hashtable.
				winners.replace(winner, score, newScore);
				
			// 7. If the home team does not exist in our hashtable...
			} else {
				
				//...then we simply add them in using 'put'.
				winners.put(winner, 3);
			}
			
			// 8. We then check and see if the score associated with the winning team is higher than the current 'highScore'. If it is...
			if(winners.get(winner) > highScore) {
				
				// ...then we update both the name of the highest scorer as well as the high score.
				highestScorer = winner;
				highScore = winners.get(winner);
			}
			
		}
	
		// 9. Once the loop iterates through all the competitions and results, we simply return our highest scorer.
		return highestScorer;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> competitions1 = new ArrayList<>();
		ArrayList<Integer> results1 = new ArrayList<>();
		ArrayList<String> comp1 = new ArrayList<>();
		ArrayList<String> comp2 = new ArrayList<>();
		ArrayList<String> comp3 = new ArrayList<>();
		
		comp1.add("HTML");
		comp1.add("C#");
		comp2.add("C#");
		comp2.add("Python");
		comp3.add("Python");
		comp3.add("HTML");
		
		results1.add(0);
		results1.add(0);
		results1.add(1);
		
		competitions1.add(comp1);
		competitions1.add(comp2);
		competitions1.add(comp3);
		
		System.out.println(tournamentWinner(competitions1, results1));
		
	}

}
