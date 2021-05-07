package kr.mjc.nayeon.web.mvc;

import kr.mjc.nayeon.web.dao.Article;
import kr.mjc.nayeon.web.dao.ArticleDao;
import kr.mjc.nayeon.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ArticleController {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * 게시글 목록 화면
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }


    /**
     * 게시글 쓰기 화면
     */
    public void articleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 상세 보기 화면 폼
     */
    public void articleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleGet.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 수정 화면
     */
        public void articleUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleUpdate.jsp")
                    .forward(request, response);
        }

    /**
     * 게시글 삭제 화면
     */
        public void articleDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleDelete.jsp")
                    .forward(request, response);
        }

    /**
     * 게시글 상세 보기 화면
     */
    public void articleView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleView.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 쓰기 액션
     */
        public void addArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Article article = new Article();
            article.setTitle(request.getParameter("title"));
            article.setContent(request.getParameter("content"));
            article.setUserId(Integer.parseInt(request.getParameter("userId")));
            article.setName(request.getParameter("name"));

                articleDao.addArticle(article);
                response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        }

    /**
     * 게시글 상세 보기 액션
     */
    public void getArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));

        try {
            Article article = articleDao.getArticle(articleId);
            HttpSession session = request.getSession();
            session.setAttribute("ARTICLE", article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleView");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=no articleId");
        }
    }

    /**
     * 게시글 수정 액션
     */
    public void updateArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
        article.setUserId(Integer.parseInt(request.getParameter("userId")));

        try {
            articleDao.updateArticle(article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleUpdate?msg=no articleId or no userId");
        }
    }

    /**
     * 게시글 삭제 액션
     */
    public void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int articleId = (Integer.parseInt(request.getParameter("articleId")));
        int userId = (Integer.parseInt(request.getParameter("userId")));

        try {
            articleDao.deleteArticle(articleId, userId);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=no articleId or no userId");
        }
    }
}
