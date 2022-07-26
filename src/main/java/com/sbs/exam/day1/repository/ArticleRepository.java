package com.sbs.exam.day1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sbs.exam.day1.vo.Article;

@Mapper
public interface ArticleRepository {
	@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, `body` = #{body}")
	public void writeArticle(@Param("title") String title, @Param("body") String body);

	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id);

	// DELETE FROM article WHERE id = ?
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(@Param("id") int id);

	// UPDATE article SET title = ?, `body` = ?, updateDate = NOW() WHERE id = ?;
	@Update("UPDATE article SET title = #{title}, `body` = #{body}, updateDate = NOW() WHERE id = #{id}")
	public void modifyArticle(@Param("id") int id,@Param("title") String title,@Param("body") String body);

	// SELECT * FROM article ORDER BY id DESC;
	@Select("SELECT * FROM article ORDER BY id DESC")
	public List<Article> getArticles();

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
}
