FROM nginx:stable

COPY default.conf /etc/nginx/conf.d/default.conf

WORKDIR /etc/nginx
CMD ["nginx", "-g", "daemon off;"]

EXPOSE 80
