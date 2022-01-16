FROM nginx

RUN rm /etc/nginx/nginx.conf
ADD nginx.conf /etc/nginx/nginx.conf

#RUN rm /etc/nginx/conf.d/default.conf
#ADD default.conf /etc/nginx/conf.d/

RUN rm /usr/share/nginx/html/index.html
COPY dist/ /usr/share/nginx/html/

RUN chmod -R 755 /usr/share/nginx/html

# 暴露端口
EXPOSE 80

# 启动 Nginx
CMD ["nginx", "-g", "daemon off;"]
