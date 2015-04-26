package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import operators.ArticleTreeGenerator;
import operators.GeneticOperators;
import tree.Tree;
import articles.Article;
import articles.ArticleDB;


public class Main {


	public static void main(String args[]) throws ClassNotFoundException, IOException { 
		
		ArticleDB articleDB = ArticleDB.getInstance();
		System.out.println(articleDB.toString());
		for(Article article: articleDB.getArticles()) {
			System.out.println(article.toString());
		}
		
		ArticleTreeGenerator treeGenerator = new ArticleTreeGenerator();
		
		List<Tree> trees = new ArrayList<Tree>();
		for(Article article: articleDB.getArticles()) {
			Tree tree = treeGenerator.generateTree(article);
			trees.add(tree);
		}
		
		GeneticOperators operators = new GeneticOperators();
		trees.get(0).printTree();
		//operators.crossover(trees.get(0), trees.get(1));
		operators.mutate(trees.get(0));
		trees.get(0).printTree();
	}


}

