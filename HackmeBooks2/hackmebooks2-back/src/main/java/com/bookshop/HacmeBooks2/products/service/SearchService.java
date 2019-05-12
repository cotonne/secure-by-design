package com.bookshop.HacmeBooks2.products.service;

import com.bookshop.HacmeBooks2.products.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

@Service
public class SearchService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Product> search(String query) {
    String[] keywords = createSearchCriteria(query);
    String sqlQuery = "select * from products where " + createCriteria(keywords);
    return jdbcTemplate.query(sqlQuery, (r, i) -> {
      Product p = new Product();
      p.setId(r.getInt("ID"));
      p.setTitle(r.getString("TITLE"));
      p.setDescription(r.getString("DESCRIPTION"));
      return p;
    });
  }

  public static String[] createSearchCriteria(String _keyWords) {
    //Break em up by spaces
    StringTokenizer tokenizer = new StringTokenizer(_keyWords, " ");
    ArrayList keyWords = new ArrayList();
    while (tokenizer.hasMoreTokens()) {
      keyWords.add(tokenizer.nextToken());
    }

    String words[] = new String[keyWords.size()];

    Iterator iter = keyWords.iterator();

    int index = 0;

    while (iter.hasNext()) {
      String element = (String) iter.next();

      words[index] = element.replace('+', ' ');
      index++;
    }


    return words;
  }

  private String createCriteria(String[] keywords) {
    if (keywords == null) {
      return "1 = 1"; // return all rows
    }
    StringBuffer criteria = new StringBuffer();
    for (int i = 0; i < keywords.length; i++) {
      String keyword = keywords[i];
      if (i == 0) {
        criteria.append("lower(title) like '%" + keyword.toLowerCase()
                + "%'");
      } else {
        criteria.append(" and lower(title) like '%"
                + keyword.toLowerCase() + "%'");
      }
    }
    return criteria.toString();
  }
}
