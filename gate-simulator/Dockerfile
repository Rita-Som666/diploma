
FROM node:16

# Устанавливаем рабочую директорию
WORKDIR /usr/src/app

# Копируем package.json и package-lock.json
COPY package*.json ./

# Устанавливаем зависимости
RUN npm install

# Копируем остальной исходный код
COPY . .

# Порт, на котором приложение будет слушать
EXPOSE 3000

# Команда по умолчанию для запуска контейнера
CMD ["npm", "start"]