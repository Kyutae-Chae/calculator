FROM nginx:stable

COPY ktchae.conf /etc/nginx/conf.d/default.conf

WORKDIR /etc/nginx
CMD ["nginx", "-g", "daemon off;"]

EXPOSE 80
